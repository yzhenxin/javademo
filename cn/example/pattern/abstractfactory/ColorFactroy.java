package cn.example.pattern.abstractfactory;

import cn.example.pattern.factory.Shape;

public class ColorFactroy extends AbstractFactory {

	@Override
	Color getColor(String colorName) {
		if (colorName == null) {
			return null;
		}
		if ("BLUE".equalsIgnoreCase(colorName)) {
			return new Blue();
		} else if ("RED".equalsIgnoreCase(colorName)) {
			return new Red();
		}
		return null;
	}

	@Override
	Shape getShape(String shapeName) {
		return null;
	}

}
