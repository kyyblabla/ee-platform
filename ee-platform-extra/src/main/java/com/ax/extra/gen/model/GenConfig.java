package com.ax.extra.gen.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by kyy on 2017/9/24.
 */
@Data
@XmlRootElement(name = "config")
public class GenConfig {

    @Data
    @XmlRootElement(name = "plan")
    public static class GenPlan {
        private String name;
        private String comment;
        private List<String> templates;

        @XmlAttribute
        public String getName() {
            return name;
        }

        @XmlAttribute
        public String getComment() {
            return comment;
        }

        @XmlElement(name = "template")
        public List<String> getTemplates() {
            return templates;
        }


    }

    private List<GenPlan> plans; //代码生成类型

    @XmlElementWrapper(name = "plans")
    @XmlElement(name = "plan")
    public List<GenPlan> getPlans() {
        return plans;
    }

}
