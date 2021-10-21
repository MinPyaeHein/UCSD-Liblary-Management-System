package com.coder.form;

import java.util.List;

import com.coder.model.Position;

public class PositionRegisterForm {
private PositionForm positionForm;
private List<Position> positions;
public PositionForm getPositionForm() {
	return positionForm;
}
public void setPositionForm(PositionForm positionForm) {
	this.positionForm = positionForm;
}
public List<Position> getPositions() {
	return positions;
}
public void setPositions(List<Position> positions) {
	this.positions = positions;
}
 }
