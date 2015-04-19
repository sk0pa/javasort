package com.epam.khalii.Sorts;

/**
 * Created by Skopa on 19.04.2015.
 */
public class Merger {

    public static int[] mergeWrong(int[] fst, int[] snd) { //Wrong
        int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;
        while (fstIndex + sndIndex != result.length) {
            if (fst[fstIndex] < snd[sndIndex]) {
                result[fstIndex + sndIndex] = fst[fstIndex++];
            } else {
                result[fstIndex + sndIndex] = snd[sndIndex++];
            }
        }
        return result;
    }

    public static int[] mergeRight(int[] fst, int[] snd) {
        int resLength = fst.length + snd.length;
        int[] result = new int[resLength];
        int fstIndex = 0;
        int sndIndex = 0;
        int index=0;
        while (index != resLength) {
            if(fstIndex<fst.length&&sndIndex<snd.length){
                if (fst[fstIndex] < snd[sndIndex]) {
                    result[index++] = fst[fstIndex++];
                } else {
                    result[index++] = snd[sndIndex++];
                }
            }
            else {
                if(fstIndex<fst.length){
                    System.arraycopy(fst, fstIndex, result, index, resLength-index);
                    break;
                } else {
                    System.arraycopy(snd, sndIndex, result, index, resLength-index);
                    break;
                }
            }
        }
        return result;
    }
}
//���������� ��������� ����������� ������� ������������� ��������

/**
 * � ������ ��������� ����� merge ���������� � ������� -
 * �� ��������� �������, �� ����������� ������������
 * ��������, ����� ���� �� �������� ��������� ������.
 * 1. ��������� ������.
 * ------------------
 * �������������� ���������:
 * 2. ����� ���� ��� �����������, ��� ���� �� ��������
 * "��������" ��������� ������ �� ������� �������
 * � ��������� �� � �����, � ����� �������
 * System.arraycopy(...).
 * 3. ���������� �������������� ���������� ��������
 * (���������, �����, ����������, ...) �� ����
 * "���������" ������� ("���������" ������� ������
 * �������������� ��������). ������ � ���� 6 ��������:
 * - fstIndex + sndIndex
 * - ... != result.length
 * - fst[fstIndex] < snd[sndIndex]
 * - fstIndex + sndIndex
 * - fstIndex++
 * - result[...] = fst[...]
 *
 */
