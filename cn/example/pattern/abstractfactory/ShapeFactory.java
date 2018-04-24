package cn.example.pattern.abstractfactory;

import cn.example.pattern.factory.Circle;
import cn.example.pattern.factory.Rectangle;
import cn.example.pattern.factory.Shape;

public class ShapeFactory extends AbstractFactory {

	@Override
	Color getColor(String colorName) {
		return null;
	}

	@Override
	Shape getShape(String shapeName) {
		if (shapeName == null) {
			return null;
		}
		if ("CIRCLE".equalsIgnoreCase(shapeName)) {
			return new Circle();
		} else if ("RECTANGLE".equalsIgnoreCase(shapeName)) {
			return new Rectangle();
		} else {
			return null;
		}
	}

}
