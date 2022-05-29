package me.talkcode.debicred.core.commons;

import java.util.Collection;

public final class ToString {
    
    public static String of(Collection<?> collection) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        var i=0;
        for(Object item: collection){
            if(i < collection.size())
                builder.append(",");
            builder.append(i);
            builder.append('=');
            builder.append(item.toString());
            i++;
        }
        builder.append(']');
        return builder.toString();
    }

    public static String of(Object[] array){
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        var i=0;
        for(Object item: array){
            if(i < array.length)
                builder.append(",");
            builder.append(i);
            builder.append('=');
            builder.append(item.toString());
            i++;
        }
        builder.append(']');
        return builder.toString();
    }
    

}
