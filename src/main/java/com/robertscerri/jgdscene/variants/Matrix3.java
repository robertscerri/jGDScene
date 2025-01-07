package com.robertscerri.jgdscene.variants;

import com.robertscerri.jgdscene.variants.vectors.Vector3;

public class Matrix3 {
    public static Matrix3 IDENTITY = new Matrix3(1, 0, 0, 0, 1, 0, 0, 0, 1);
    public static Matrix3 ZERO = new Matrix3(0, 0, 0, 0, 0, 0, 0, 0, 0);

    public double[][] cells;

    public Matrix3() {
        this.cells = new double[3][3];
    }

    public Matrix3(Vector3 col1, Vector3 col2, Vector3 col3) {
        this.cells = new double[3][3];
        this.cells[0][0] = col1.x;
        this.cells[0][1] = col2.x;
        this.cells[0][2] = col3.x;
        this.cells[1][0] = col1.y;
        this.cells[1][1] = col2.y;
        this.cells[1][2] = col3.y;
        this.cells[2][0] = col1.z;
        this.cells[2][1] = col2.z;
        this.cells[2][2] = col3.z;
    }

    public Matrix3(double e11, double e12, double e13, double e21, double e22, double e23, double e31, double e32, double e33) {
        this.cells = new double[3][3];
        this.cells[0][0] = e11;
        this.cells[0][1] = e12;
        this.cells[0][2] = e13;
        this.cells[1][0] = e21;
        this.cells[1][1] = e22;
        this.cells[1][2] = e23;
        this.cells[2][0] = e31;
        this.cells[2][1] = e32;
        this.cells[2][2] = e33;
    }

    public Matrix3(Matrix3 from) {
        this.cells = from.cells.clone();
    }

    public Matrix3 affineInverse() {
        double det = this.determinant();

        if (det == 0) {
            return Matrix3.IDENTITY;
        }

        double invDet = 1.0 / det;

        double c11 = this.cells[1][1] * this.cells[2][2] - this.cells[2][1] * this.cells[1][2];
        double c12 = -(this.cells[1][0] * this.cells[2][2] - this.cells[2][0] * this.cells[1][2]);
        double c13 = this.cells[1][0] * this.cells[2][1] - this.cells[2][0] * this.cells[1][1];

        double c21 = -(this.cells[0][1] * this.cells[2][2] - this.cells[2][1] * this.cells[0][2]);
        double c22 = this.cells[0][0] * this.cells[2][2] - this.cells[2][0] * this.cells[0][2];
        double c23 = -(this.cells[0][0] * this.cells[1][2] - this.cells[1][0] * this.cells[0][2]);

        double c31 = this.cells[0][1] * this.cells[1][2] - this.cells[1][1] * this.cells[0][2];
        double c32 = -(this.cells[0][0] * this.cells[1][2] - this.cells[1][0] * this.cells[0][2]);
        double c33 = this.cells[0][0] * this.cells[1][1] - this.cells[1][0] * this.cells[0][1];

        return new Matrix3(
                c11 * invDet, c12 * invDet, c13 * invDet,
                c21 * invDet, c22 * invDet, c23 * invDet,
                c31 * invDet, c32 * invDet, c33 * invDet
        );
    }

    public double determinant() {
        return this.cells[0][0] * (this.cells[1][1] * this.cells[2][2] - this.cells[2][1] * this.cells[1][2])
                - this.cells[0][1] * (this.cells[1][0] * this.cells[2][2] - this.cells[2][0] * this.cells[1][2])
                + this.cells[0][2] * (this.cells[1][0] * this.cells[2][1] - this.cells[2][0] * this.cells[1][1]);
    }

    public Matrix3 multiply(Matrix3 right) {
        Matrix3 result = new Matrix3();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                for (int i = 0; i < 3; i++) {
                    result.cells[row][col] += this.cells[row][i] * right.cells[i][col];
                }
            }
        }

        return result;
    }
}
