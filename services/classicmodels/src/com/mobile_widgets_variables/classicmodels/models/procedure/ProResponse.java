/*Generated by WaveMaker Studio*/
package com.mobile_widgets_variables.classicmodels.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class ProResponse implements Serializable {


    @ColumnAlias("count")
    private Integer _count;

    public Integer get_count() {
        return this._count;
    }

    public void set_count(Integer _count) {
        this._count = _count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProResponse)) return false;
        final ProResponse proResponse = (ProResponse) o;
        return Objects.equals(get_count(), proResponse.get_count());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_count());
    }
}
