package cn.example.pattern.factory;

public class FactoryPattern {
	public static Shape getShapeFactory(String shapeName) {
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
