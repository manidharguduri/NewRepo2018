package com.m.g.array;

import com.m.g.util.ArrayUtil;

import java.util.Optional;

public class RotateArrayLeftWithOutExtraSpaceReturnValue {

    public static void main(String[] args) {

        // test case : 1
        int[] arr1 = {11, 22, 33, 44, 56, 89, 92};
        RotateArrayLeftWithOutExtraSpaceReturnValue r = new RotateArrayLeftWithOutExtraSpaceReturnValue();
        int[] res = r.rotateArray(arr1, 8);
        ArrayUtil.printArray(res);


    }

    public int[] rotateArray(int[] array, int distance) {
        int rotateDist = distance % array.length;
        rotateArrayToLeftByDElements(array, rotateDist);
        return array;
    }

    private int[] rotateArrayToLeftByDElements(int[] array, int rotateDist) {

        Optional.ofNullable(array).filter(input -> input.length > 0).ifPresent(arr1 -> {
            ArrayUtil.reverseArray(arr1, 0, rotateDist - 1);
            ArrayUtil.reverseArray(arr1, rotateDist, arr1.length - 1);
            ArrayUtil.reverseArray(arr1, 0, arr1.length - 1);
        });

        return array;
    }




}

