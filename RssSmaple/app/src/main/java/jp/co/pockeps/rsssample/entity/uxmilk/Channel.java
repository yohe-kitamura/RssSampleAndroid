package jp.co.pockeps.rsssample.entity.uxmilk;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Channel {
    @ElementList(name = "item", inline = true, required = false)
    public List<Item> items;
}
