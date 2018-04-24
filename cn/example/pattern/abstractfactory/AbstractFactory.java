package cn.example.pattern.abstractfactory;

import cn.example.pattern.factory.Shape;

public abstract class AbstractFactory {
	abstract Color getColor(String colorName);
	abstract Shape getShape(String shapeName);
}
