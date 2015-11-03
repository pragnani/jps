package com.pbsi.training.beans;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class GlobalWrapper<T> extends ArrayList<T> {
	
}
