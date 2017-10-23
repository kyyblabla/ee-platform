package com.ax.extra.gen.model;

import com.ax.extra.gen.model.GenScheme;
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

    @Data
    public static class JdbcConnection {
        private String driverClassName;
        private String url;
        private String username;
        private String password;
    }

    @Data
    public static class GenProperty {
        private String genPlan;
        private String replaceFile;
        private String typeHandle;
        private String packageName;
        private String prefixPattern;
    }

    private List<GenPlan> plans;
    private JdbcConnection jdbcConnection;
    private List<String> typeConverts;
    private GenProperty genProperty;
    private List<GenScheme> schemes;


    @XmlElementWrapper(name = "plans")
    @XmlElement(name = "plan")
    public List<GenPlan> getPlans() {
        return plans;
    }

    @XmlElementWrapper(name = "typeConverts")
    @XmlElement(name = "typeConvert")
    public List<String> getTypeConverts() {
        return typeConverts;
    }

    @XmlElementWrapper(name = "schemes")
    @XmlElement(name = "scheme")
    public List<GenScheme> getSchemes() {
        return schemes;
    }
}
