package com.commerce.util;

/**
 * Created by suat on 12/25/16.
 */
public class NumberOperations {

    public static Number addNumber(Number number1, Number number2) {
        if(number1 instanceof Double || number2 instanceof Double) {
            return new Double(number1.doubleValue() + number2.doubleValue());
        } else if(number1 instanceof Float || number2 instanceof Float) {
            return new Float(number1.floatValue() + number2.floatValue());
        } else if(number1 instanceof Long || number2 instanceof Long) {
            return new Long(number1.longValue() + number2.longValue());
        } else {
            return new Integer(number1.intValue() + number2.intValue());
        }
    }

    public static Number multiplyNumber(Number number1, Number number2) {
        if(number1 instanceof Double || number2 instanceof Double) {
            return new Double(number1.doubleValue() * number2.doubleValue());
        } else if(number1 instanceof Float || number2 instanceof Float) {
            return new Float(number1.floatValue() * number2.floatValue());
        } else if(number1 instanceof Long || number2 instanceof Long) {
            return new Long(number1.longValue() * number2.longValue());
        } else {
            return new Integer(number1.intValue() * number2.intValue());
        }
    }

    public static Number divideNumberForDouble(Number number1, Number number2) {
        return new Double(number1.doubleValue() / number2.doubleValue());
    }
}
