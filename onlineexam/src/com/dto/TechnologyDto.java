package com.dto;

import java.io.Serializable;

public class TechnologyDto implements Serializable
{

    private Integer technologyId;
    private String technologyName;

    public Integer getTechnologyId()
    {
        return this.technologyId;
    }

    public void setTechnologyId(Integer technologyId)
    {
        this.technologyId = technologyId;
    }

    public String getTechnologyName()
    {
        return this.technologyName;
    }

    public void setTechnologyName(String technologyName)
    {
        this.technologyName = technologyName;
    }

}
