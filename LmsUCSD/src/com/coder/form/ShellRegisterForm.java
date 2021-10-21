package com.coder.form;

import java.util.List;

import com.coder.model.Shell;

public class ShellRegisterForm {
private ShellForm shellForm;
private List<Shell> shells;
private List<ShellForm> shellForms;
public List<Shell> getShells() {
	return shells;
}

public void setShells(List<Shell> shells) {
	this.shells = shells;
}

public ShellForm getShellForm() {
	return shellForm;
}

public void setShellForm(ShellForm shellForm) {
	this.shellForm = shellForm;
}

public List<ShellForm> getShellForms() {
	return shellForms;
}

public void setShellForms(List<ShellForm> shellForms) {
	this.shellForms = shellForms;
}


}
