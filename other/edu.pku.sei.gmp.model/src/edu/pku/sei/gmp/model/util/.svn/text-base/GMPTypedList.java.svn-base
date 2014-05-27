package edu.pku.sei.gmp.model.util;
import java.util.ArrayList;
import java.util.Collection;

import edu.pku.sei.gmp.model.concept.GMPElement;

public class GMPTypedList<T> extends ArrayList<T> {
	private static final long serialVersionUID = 6806825062676200118L;

	protected GMPElement owner;
	protected String name;
	protected String containerType;
	protected Class<T> dataType;
	protected boolean container;
	
	// allow multi-instance
	final public static String BAG = "__GMP_TYPED_CONTAINER_TYPE_LIST__";
	// singleton
	final public static String SET = "__GMP_TYPED_CONTAINER_TYPE_SET__";

	public GMPTypedList(String name, String containerType,
			GMPElement owner, Class<T> dataType, boolean container) {
		this.name = name;
		this.containerType = containerType;
		this.owner = owner;
		this.dataType = dataType;
		this.container = container;
	}

	public Class<T> getDataType() {
		return dataType;
	}

	public boolean add(T element) {
		if (containerType == BAG) {
			return bagAdd(element);
		} else {
			return setAdd(element);
		}
	}

	private boolean bagAdd(T element) {

		if (element.getClass().equals(dataType) || dataType.isInstance(element)) {
			if (super.add(element)) {
				owner.firePropertyChange(name, this, element);
				if (container && element instanceof GMPElement) {
					((GMPElement) element).setContainer(owner);
				}
				return true;
			}
			return false;
		} else {
			throw new IllegalArgumentException("Element "
					+ element.getClass().getCanonicalName()
					+ " is not an instanceof " + dataType);
		}
	}

	private boolean setAdd(T element) {
		if (element.getClass().equals(dataType) || dataType.isInstance(element)) {
			if (super.contains(element))
				return false;

			if (super.add(element)) {
				owner.firePropertyChange(name, this, element);
				if (container && element instanceof GMPElement) {
					((GMPElement) element).setContainer(owner);
				}
				return true;
			}
			return false;
		} else {
			throw new IllegalArgumentException("Element "
					+ element.getClass().getCanonicalName()
					+ " is not an instanceof " + dataType);
		}
	}

	public void add(int index, T element) {
		if (containerType == BAG) {
			bagAdd(index, element);
		} else {
			setAdd(index, element);
		}
	}

	private void bagAdd(int index, T element) {
		if (element.getClass().equals(dataType) || dataType.isInstance(element)) {
			super.add(index, element);
			owner.firePropertyChange(name, this, element);
			if (container && element instanceof GMPElement) {
				((GMPElement) element).setContainer(owner);
			}
		}
	}

	private void setAdd(int index, T element) {
		if (element.getClass().equals(dataType) || dataType.isInstance(element)) {

			if (super.contains(element))
				return;
			super.add(index, element);
			owner.firePropertyChange(name, this, element);
			if (container && element instanceof GMPElement) {
				((GMPElement) element).setContainer(owner);
			}
		}
	}

	public boolean remove(Object element) {
		if (element.getClass().equals(dataType) || dataType.isInstance(element)) {
			if (super.remove(element)) {
				owner.firePropertyChange(name, this, element);
				if (container && element instanceof GMPElement) {
					((GMPElement) element).setContainer(null);
				}
				return true;
			}
		}
		return false;
	}

	public T remove(int index) {
		T element = (T) super.remove(index);
		if (element != null) {
			owner.firePropertyChange(name, this, element);
			if (container && element instanceof GMPElement) {
				((GMPElement) element).setContainer(null);
			}
		}
		return element;
	}

	public void clear() {
		for (int i = 0; i < size(); i++) {
			T element = get(i);
			if (container && element instanceof GMPElement) {
				((GMPElement) element).setContainer(null);
			}
		}
		super.clear();
		owner.firePropertyChange(name, this, this);
	}

	@SuppressWarnings("unchecked")
	public boolean addAll(Collection list) {
		boolean result = false;
		Object[] listArr = list.toArray();
		for (int i = 0; i < listArr.length; i++) {
			Object element = listArr[i];
			if (element.getClass().equals(dataType)
					|| dataType.isInstance(element)) {
				if (this.contains(element)) {
					continue;
				}
				super.add((T) element);
				result = true;
				if (container && element instanceof GMPElement) {
					((GMPElement) element).setContainer(owner);
				}
			}
		}
		owner.firePropertyChange(name, this, list);
		return result;
	}
}
