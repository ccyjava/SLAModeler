package edu.pku.sei.gmp.model.msg;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import edu.pku.sei.gmp.model.concept.GMPElement;

/**
 * An aspect for introducing message notification facility to the
 * {@link GMPElement}
 * 
 * @author yangyz
 * 
 */
public aspect GMPListenerSupport {
	/**
	 * introduce a field
	 */
	private PropertyChangeSupport GMPElement.listenerSupport;

	public void GMPElement.setListenerSupport(PropertyChangeSupport support) {
		this.listenerSupport = support;
	}

	/**
	 * initialize the listenerSupport
	 * 
	 * @param element
	 */
	after(GMPElement element) : execution (GMPElement.new(..)) && target(element) {
		element.setListenerSupport(new PropertyChangeSupport(element));
	}

	/**
	 * add a {@link PropertyChangeListerner}. If the {@code listener} is added
	 * to the listenerSupport already, it will not be added for the second time.
	 * 
	 * @param listener
	 */
	public void GMPElement.addPropertyChangeListener(
			PropertyChangeListener listener) {
		for (PropertyChangeListener l : listenerSupport
				.getPropertyChangeListeners()) {
			if (l == listener) {
				return;
			}
		}
		listenerSupport.addPropertyChangeListener(listener);
	}

	/**
	 * remove a {@link PropertyChangeListerner}.
	 * 
	 * @param listener
	 */
	public void GMPElement.removePropertyChangeListener(
			PropertyChangeListener listener) {
		listenerSupport.removePropertyChangeListener(listener);
	}

	public PropertyChangeListener[] GMPElement.getPropertyChangeListeners() {
		return listenerSupport.getPropertyChangeListeners();
	}

	public void GMPElement.addPropertyChangeListeners(
			PropertyChangeListener[] listeners) {
		if (listeners == null)
			return;
		for (int i = 0; i < listeners.length; i++) {
			this.addPropertyChangeListener(listeners[i]);
		}
	}

	public void GMPElement.firePropertyChange(String propertyName,
			Object oldValue, Object newValue) {
		if (listenerSupport != null)
			listenerSupport
					.firePropertyChange(propertyName, oldValue, newValue);
	}

	public void GMPElement.refresh(String propertyName) {
		if (listenerSupport != null)
			listenerSupport.firePropertyChange(propertyName, null, null);
	}
}
