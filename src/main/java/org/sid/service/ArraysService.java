package org.sid.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysService {


    public boolean firstLast6(int[] nums) {
        return nums[0] == 6 || nums[nums.length-1] == 6;
    }

    public boolean sameFirstLast(int[] nums) {
        if( nums.length<1) return false ;
        return nums[0] == nums[nums.length -1];
    }

    public int[] makePi() {
        return new int []{3,1,4} ;
    }

    public boolean commonEnd(int[] a, int[] b) {
        return a[0] == b[0] || a[a.length-1] == b[b.length-1] ;
    }
    public int sum3(int[] nums) {
        return  Arrays.stream(nums).sum();
    }

    public boolean unlucky1(int[] nums) {
       for (int i =0; i<nums.length -1 ; i++){
           if(nums[i]==1 && nums[i+1]==3) return  true;
       }
       return  false;
    }

    public int[] biggerTwo(int[] a, int[] b) {
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        return sumA < sumB ? b: a;
    }


    public int[] makeLast(int[] nums) {
        int[] numsCopy= Arrays.copyOf(nums, nums.length *2) ;
        for (int i = 0; i < numsCopy.length; i++) {
            if(i != (numsCopy.length-1)) numsCopy[i]=0;
        }
        return numsCopy;
    }


}
