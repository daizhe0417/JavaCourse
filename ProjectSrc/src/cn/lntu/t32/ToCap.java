/*
 * @(#)ToCap.java	1.24 03/12/19
 *
 * Copyright 2006 CazoSoft, Inc. All rights reserved.
 */

package cn.lntu.t32;

/**
 * <code> ToCap </code>
 * <p>
 * ��������ת�����Ĵ�д�����
 * 
 * @author 
 * @version 22.14, 04/05/06
 * @since CAZOSOFT 1.0
 */
public class ToCap {

    /**
     * �û����ô�дǮ��(100,000,000 (һ��)����).
     * 
     * @param money :
     *            String �����û�����ʵ��.
     * @return : String ���� Բ�� �� �Ƿֵ����Ĵ�д�����,���Ϸ�,�����ؿ�(null)
     */
    public String setMoney(String money) {

        String re = null;
        double num;
        
        //��������Ƿ�Ϸ�
        try {
            num = Double.parseDouble(money.trim());
            if (num < 100000000 && num >= 0) {
                //�Ϸ�, ʹ���ַ�ʼת��
                re = this.mySetMoney(money);
            }//end if
        } catch (Exception ex) {
        }//end try
        //����ֵ
        return re;
    }
    
    /**
     * ��дת������. ����: ת������Ϊ���Ĵ�д
     * 
     * @param num :
     *            int ��������
     * @return : String ��д���� �� �� ��.
     */
    private String setDaXie(int num) {

        String re = null;
        switch (num) {
        case 0:
            re = "��";
            break;
        case 1:
            re = "Ҽ";
            break;
        case 2:
            re = "��";
            break;
        case 3:
            re = "��";
            break;
        case 4:
            re = "��";
            break;
        case 5:
            re = "��";
            break;
        case 6:
            re = "½";
            break;
        case 7:
            re = "��";
            break;
        case 8:
            re = "��";
            break;
        case 9:
            re = "��";
            break;
        default:
            break;
        }
        return re;
    }

    /**
     * �����д�����
     * 
     * @param num :
     *            String ���մ������ַ�(ʵΪ����).
     * @return : ���ش����Ĵ�д�����.
     */
    private String mySetMoney(String num) throws Exception {

        //Ҫ���ص��ַ�
        String re = "";

        //ת�����
        String setNum = null;
        int index = num.indexOf(".");

        //��������
        if (index == -1) {
            setNum = num;
        } else {
            setNum = num.substring(0, index);
        }
        int weiShu = setNum.length();
        if (weiShu > 0) {
            int leng = setNum.length();
            int numYuan = Integer.parseInt("" + setNum.charAt(weiShu - 1));
            String zhuanYuan = setDaXie(numYuan);
            re = zhuanYuan;
            //��λ
            if (weiShu > 1) {
                int numShi = Integer.parseInt("" + setNum.charAt(weiShu - 2));
                String zhuanShi = setDaXie(numShi);
                //ʮλ
                re = zhuanShi + "ʰ" + re;
                if (weiShu > 2) {
                    int numBai = Integer.parseInt(""
                            + setNum.charAt(weiShu - 3));
                    String zhuanBai = setDaXie(numBai);
                    //��λ
                    re = zhuanBai + "��" + re;
                    if (weiShu > 3) {
                        int numQian = Integer.parseInt(""
                                + setNum.charAt(weiShu - 4));
                        String zhuanQian = setDaXie(numQian);
                        //ǧλ
                        re = zhuanQian + "Ǫ" + re;
                        if (weiShu > 4) {
                            int numWan = Integer.parseInt(""
                                    + setNum.charAt(weiShu - 5));
                            String zhuanWan = setDaXie(numWan);
                            //��λ
                            re = zhuanWan + "��" + re;
                            if (weiShu > 5) {
                                int numShiWan = Integer.parseInt(""
                                        + setNum.charAt(weiShu - 6));
                                String zhuanShiWan = setDaXie(numShiWan);
                                //ʮ��λ
                                re = zhuanShiWan + "ʰ" + re;
                                if (weiShu > 6) {
                                    int numBaiWan = Integer.parseInt(""
                                            + setNum.charAt(weiShu - 7));
                                    String zhuanBaiWan = setDaXie(numBaiWan);
                                    //����λ
                                    re = zhuanBaiWan + "��" + re;
                                    if (weiShu > 7) {
                                        int numQianWan = Integer.parseInt(""
                                                + setNum.charAt(weiShu - 8));
                                        String zhuanQianWan = setDaXie(numQianWan);
                                        //ǧ��λ
                                        re = zhuanQianWan + "Ǫ" + re;
                                    }//end qianwan
                                }//end baiwan
                            }//end shiwan
                        }//end wan
                    }//end qian
                }//end bai
            }//end shi
        }//end yuan
      
        //����С��
        if (index != -1) {
            String xiaoShu = num.substring(index + 1, num.length());
            int leng = xiaoShu.length();
            int numJiao = Integer.parseInt("" + xiaoShu.charAt(0));
            String zhuanJiao = setDaXie(numJiao);
            int numFen;
            if (leng == 1) {
                numFen = 0;
            }//end if
            numFen = Integer.parseInt("" + xiaoShu.charAt(1));
            String zhuanFen = setDaXie(numFen);
            //ʮ��λ+�ٷ�λ
            if (numJiao == 0 && numFen != 0 || numJiao != 0 && numFen != 0) {
                re = re + "Բ" + zhuanJiao + "��" + zhuanFen + "��";
            } else {
                re = re + "Բ��";
            }//end if
        } else {
            re = re + "Բ��";
        }//end index

        return re;
    }
}