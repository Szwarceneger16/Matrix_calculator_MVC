package szwarcgrzegorz.matrixcalculator.controller;

import szwarcgrzegorz.matrixcalculator.model.Matrix;

public class Operations {

    public static void multiply(Matrix factor1, Matrix factor2, Matrix product){
        for (int i = 0; i < factor1.getRows(); i++) {
            for (int j = 0; j < factor1.getRows(); j++) {
                for (int k = 0; k < factor1.getColumns(); k++) {
                    product.addElement(i,j,factor1.getElement(i,k) * factor2.getElement(k,j));
                }
            }
        }
    }

    public static Matrix transpose(Matrix actual){
        Matrix tmp = new Matrix(actual.getColumns(),actual.getRows(),"C");
        for (int i = 0; i < actual.getRows(); i++) {
            for (int j = 0; j < actual.getColumns(); j++) {
                tmp.setElement(j,i,actual.getElement(i,j));
            }
        }
        return tmp;
    }
}
