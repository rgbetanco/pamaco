// Comparator Utilities
// Copyright (c) 2002 Alex Blewitt <Alex.Blewitt@ioshq.com>
// Copyright (c) 2002 JavaWorld
// First published by JavaWorld in December 2002
// http://www.javaworld.com/javaworld/jw-12-2002/jw-1227-sort.html
//
//    This library is free software; you can redistribute it and/or 
//    modify it under the terms of the GNU Lesser General Public
//    License as published by the Free Software Foundation; either
//    version 2.1 of the License, or (at your option) any later version.
//
//    This library is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//    Lesser General Public License for more details.
//
//    You should have received a copy of the GNU Lesser General Public
//    License along with this library; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//  
//    Alternatively, it is downloadable at http://www.gnu.org/licenses/lgpl.txt
//
//  For more information, see the COPYRIGHT notice in the root directory 

package com.nicahost.common.util;

import java.util.Comparator;


/** Compares two objects by comparing a named JavaBeans property.
 *
 * Comparators only allow two objects to be compared in entierity. This provides
 * a generic way of comparing two JavaBeans by specifying their property name
 * and the appropriate values are computed dynamically at run time.
 * 
 * Example of use:
 *
 * <PRE>
 * public class PersonBean {
 *   private String name;
 *   public PersonBean(String name) {
 *   this.name = name;
 *   }
 *   public String getName() {
 *    return name;
 *   }
 * }
 * 
 * Comparator c = new BeanPropertyComparator("name");
 * // returns -1
 * c.compare(new PersonBean("Alex"),new PersonBean("Bob"));
 * 
 * // returns 0
 * c.compare(new PersonBean("Alex"),new PersonBean("Alex));
 * 
 * // returns 1
 * c.compare(new PersonBean("Bob"),new PersonBean("Bob"));
 * </PRE>
 *
 * <B>Note</B> the <I>property</I> is the name of a JavaBeans property, and
 * according to the JavaBeans specification must start with a lower case letter.
 * So, the property <CODE>name</CODE> is translated to the method 
 * <CODE>getName()</CODE> using the standard {@link java.beans.Introspector}
 * process.
 * <P>
 * <B>Note</B> this uses the {@link java.beans.BeanInfo} class to obtain the
 * accessor method, so that provided a
 * {@link java.beans.BeanInfo} is given, it will work regardless of the name
 * of the read method.
 * 
 * @author Alex Blewitt &lt;<I><A href="mailto:Alex.Blewitt@ioshq.com">Alex.Blewitt@ioshq.com</A></I>&gt;
 * @version 1.0
 */
public class BeanPropertyComparator implements Comparator {

  /**
   * The property name.
   * 
   * Must start with a lower-case letter as per the JavaBeans specification.
   */
  private String property;

  /** The alternative comparator to use.
   * 
   * Allows properties to be compared with different comparators. If this is
   * not provided, uses the object's own {@link Comparable} interface if
   * it exists.
   */
  private Comparator comparator;

  /** Creates a new Comparator using the property defined.
   *
   * Property names must start with a lower-case letter as per the
   * JavaBeans specification. This uses {@link java.beans.Introspector introspection} to obtain
   * the property dynamically from its access method.
   *
   * The properties are compared assuming that the bean implements {@link java.lang.Comparable}.
   *
   *
   * @param property the property name to use (starts with a lower case letter)
   */  
  public BeanPropertyComparator(String property) {
    this(property,null);
  }

  /** Creates a new Comparator using the property defined.
   *
   * Property names must start with a lower-case letter as per the
   * JavaBeans specification. This uses {@link java.beans.Introspector introspection} to obtain
   * the property dynamically from its access method.
   *
   * The properties are compared using the given comparator.
   *
   * @param property the property name to use (starts with a lower case letter)
   * @param comparator the comparator to compare properties
   */  
  public BeanPropertyComparator(String property, Comparator comparator) {
    this.property = property;
    this.comparator = comparator;
  }

  /** Compares the two objects using either the given {@link java.util.Comparator} or using the {@link java.lang.Comparable} interface.
   *
   * If no {@link java.util.Comparator} is given during construction,
   * and either <CODE>o1</CODE> or <CODE>o2</CODE> implements
   * {@link java.lang.Comparable}, then it is cast to 
   * {@link java.lang.Comparable} and compared with the other.
   *
   * If no {@link java.util.Comparator} is given, and neither <CODE>o1</CODE>
   * or <CODE>o2</CODE> implement {@link java.lang.Comparable} then the
   * objects are converted to a <CODE>String</CODE> using the
   * {@link java.lang.String#valueOf} method (which calls 
   * {@link java.lang.Object#toString}), and standard <CODE>String</CODE>
   * comparison is performed.
   *
   * @param o1 the object to compare
   * @param o2 the object to compare
   * @return 
   * <DL>
   * <DT>-1</DT><DD>if <CODE>o1</CODE> &lt; <CODE>o2</CODE></DD>
   * <DT>0</DT><DD>if <CODE>o1</CODE> = <CODE>o2</CODE></DD>
   * <DT>1</DT><DD>if <CODE>o1</CODE> &gt; <CODE>o2</CODE></DD>
   * </DL>
   * @throws IllegalArgumentException if there is no property named 
   * <I>property</I> or there is a problem accessing it with the 
   * <CODE>PropertyDescriptor</CODE>
   * @see com.ioshq.util.BeanPropertyUtil#getProperty
   */  
  public int compare(Object o1, Object o2) throws IllegalArgumentException {
    // Get the value of the properties
    Object p1 = BeanPropertyUtil.getProperty(property,o1);
    Object p2 = BeanPropertyUtil.getProperty(property,o2);
    if (comparator == null) {
      // try to find p1 or p2 that implements Comparator
      if (p1 instanceof Comparable) {
        return ((Comparable)p1).compareTo(p2);
      } else if (p2 instanceof Comparable) {
        return ((Comparable)p2).compareTo(p1);
      } else {
        // we have no comparables; try String comparison
        String s1 = String.valueOf(p1); // calls toString safely
        String s2 = String.valueOf(p2); 
        return s1.compareTo(s2); // String implements comparable
      }
    } else {
      return comparator.compare(p1,p2);
    }
  }
}
