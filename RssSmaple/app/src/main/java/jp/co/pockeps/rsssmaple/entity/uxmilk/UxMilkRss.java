package jp.co.pockeps.rsssmaple.entity.uxmilk;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name="rss",strict = false)
public class UxMilkRss {
    @Element
    public Channel channel;

    public List<Item> getItems(){
        if(channel == null){
            return new ArrayList<>();
        }

        return channel.items;
    }

}
