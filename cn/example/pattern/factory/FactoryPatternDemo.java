package cn.example.pattern.factory;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		FactoryPattern.getShapeFactory("CIRCLE").draw();
		FactoryPattern.getShapeFactory("RECTANGLE").draw();
	}
}
