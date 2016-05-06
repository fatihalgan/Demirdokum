/*
 * Created on 08.Mar.2005
 *
 */
package com.iztek.dd.IsiKaybi.domain;

import java.io.Serializable;

/**
 * @author Selim HENDRICKSON
 *
 */
public interface IsiticiModeliInt extends Serializable{
    public abstract double getGuc();

    public abstract void setGuc(double guc);

    public abstract String getModelAdi();

    public abstract void setModelAdi(String modelAdi);

    public abstract String getTip();

    public abstract void setTip(String tip);

    public String getImageFile();
}