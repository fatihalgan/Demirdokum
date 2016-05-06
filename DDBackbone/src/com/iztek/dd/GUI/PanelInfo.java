package com.iztek.dd.GUI;


public class PanelInfo
{

    public PanelInfo(String scenarioName, String panelName)
    {
        this.scenarioName = null;
        this.panelName = null;
        this.scenarioName = scenarioName;
        this.panelName = panelName;
    }

    public String toString()
    {
        return scenarioName;
    }

    public String getPanelName()
    {
        return panelName;
    }

    public String getScenarioName()
    {
        return scenarioName;
    }

    public void setPanelName(String string)
    {
        panelName = string;
    }

    public void setScenarioName(String string)
    {
        scenarioName = string;
    }

    public String scenarioName;
    public String panelName;
}