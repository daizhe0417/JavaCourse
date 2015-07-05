/*
 * @(#)CsHashtable.java	1.24 03/12/19
 * 
 * public class
 *
 * Copyright 2006 CazoSoft, Inc. All rights reserved.
 */

package cn.lntu.t32;

import java.util.*;

/**
 * <code> CsHashtable </code>
 * <p>
 * ����������Ƿ�װ��ϣ��
 * <p>
 * <strong>ע��: </strong> ����ʹ�õĹ�ϣ�?�� put, ���ܴ��ڲ���ȫ����
 * <p>
 * ����ࣺHashtable
 * 
 * @author 
 * @version 2006.3.28 22:18
 * @see java.util.Hashtable
 * @since CAZOSOFT 1.0
 */
public class CsHashtable {

    /**
     * ��̬���� ����: ����һ�� hashtable ��������ʹ��
     */
    private static Hashtable hTable = new Hashtable();

    /**
     * ���캯�� ����: ���캯��Ϊ��̬�Ĳ��ܴ�������
     */
    private CsHashtable() {
    }

    /**
     * ��������� ����: �Ѷ�������ϣ��,����ΪObject����
     * 
     * @param key :
     *            ��ֵ, Object ����
     * @param value :
     *            ����, Object ����
     */
    public static void put(Object key, Object value) {
        hTable.put(key, value);
    }

    /**
     * ���ض����� ����: �ӹ�ϣ����ȡ������,����ΪObject����
     * 
     * @param key :
     *            ��ֵ
     * @return : һ�� Object ����
     */
    public static Object get(Object key) {
        return hTable.get(key);
    }

    /**
     * ���ش�С���� ����: ���ع�ϣ��Ĵ�С
     * 
     * @return : һ�� int ��ϣ�?��ֵ
     */
    public static int size() {
        return hTable.size();
    }
    
    /**
     * �Ƴ�һ������
     * 
     * @param key : ����һ��Ҫ�Ƴ�ļ�ֵ
     */
    public static Object remove(Object key) {
        return hTable.remove(key);
    }
}