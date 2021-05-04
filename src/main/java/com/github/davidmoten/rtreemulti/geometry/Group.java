package main.java.com.github.davidmoten.rtreemulti.geometry;

import java.util.List;

import com.github.davidmoten.rtreemulti.internal.Util;

public class Group<T extends HasGeometry> implements HasGeometry {

    private final List<T> list;
    private final Rectangle mbr;

    public Group(List<T> list) {
        this.list = list;
        this.mbr = Util.mbr(list);
    }

    public List<T> list() {
        return list;
    }

    @Override
    public Geometry geometry() {
        return mbr;
    }

}
