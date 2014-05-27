package edu.pku.sei.gmp.properties.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * @author yangyz
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GMPAnnotation {
	/**
	 * Property name, appears as attribute name in an XML file. It is usually
	 * set by a constant in {@link GMPConst} or its sub classes.
	 * <p>
	 * eg: the name of the field {@code container} in {@link GMPElement} may be
	 * set as {@code GMPConst.ELEMENT_CONTAINER}
	 * 
	 * @return
	 */
	public String name() default "";
	
	/**
	 * The property name displayed in the property sheet. This item may
	 * generally equal to the name of the property, and it may not be given by
	 * the user of this annotation. You can apply it a different value when you
	 * want to custom it.
	 * 
	 * @return
	 */
	public String displayName() default "";

	/**
	 * Property id, by which one property is distinguished from each other.
	 * 
	 * @return
	 */
	public String id() default "";

	/**
	 * Property category, indicate which category the field belongs to. This
	 * item is used by the property sheet to group all the properties.
	 * 
	 * @return
	 */
	public String category() default "Model";

	/**
	 * The getter method name of the field. The getter method must have no
	 * parameter, and its return type is the same as the field type.
	 * 
	 * @return
	 */
	public String getter() default "";

	/**
	 * The setter method name of the field. The setter method must have one
	 * parameter of the same type as the field, and return nothing.
	 * <p>
	 * If the field is a {@link GMPTypedList}, the setter of the field may not
	 * be given, you'd better leave this descriptor blank.
	 * 
	 * @return
	 */
	public String setter() default "";

	/**
	 * This annotation indicates whether the target field is a reference.
	 * <p>
	 * eg: the {@code container} in {@link GMPElement} is a reference to another
	 * {@link GMPElement}, and you have to set a positive value to this
	 * annotation. While the {@link subNodes} in {@link GMPShapeContainer} is
	 * not a reference. All the sub nodes of one {@link GMPShapeContainer} is
	 * kept there.
	 * 
	 * @return
	 */
	public boolean reference() default false;

	/**
	 * If the field is editable from property sheet.
	 * 
	 * @return
	 */
	public boolean readonly() default false;

	/**
	 * This value indicates whether the field can be displayed in the property
	 * sheet. If this value is false, the property sheet will not display this
	 * item.
	 * 
	 * @return
	 */
	public boolean visible() default false;
	
	/**
	 * This item indicates whether the element need refresh when the target
	 * field is modified.
	 * <p>
	 * Under common situations, one element must be refreshed(call {@code
	 * firePropertyChange()} method) when one field of which is modified. But
	 * you may custom that facility, and all you need to do is changing this
	 * value to {@code false}.
	 * 
	 * @return
	 */
	public boolean refresh() default true;
	
	/**
	 * This item indicates whether the attribute need be serialized. If this
	 * value is set to be {@code false}, the serialization facility will ignore
	 * this attribute.
	 * 
	 * @return
	 */
	public boolean serialize() default true;
}
