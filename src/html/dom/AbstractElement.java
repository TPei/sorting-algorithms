package html.dom;

import html.Renderable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractElement implements Renderable {

    public enum Position {
        ABSOLUTE("absolute"),
        RELATIVE("relative"),
        STATIC("static"),
        FIXED("fixed");

        private String value;

        private Position(String value) {
            this.value = value;
        }
    }

    class StyleAttribite {
        public StyleAttribite(String name, String value, String unit) {
            this.name = name;
            this.value = value;
            this.unit = unit;
        }

        public String name;
        public String value;
        public String unit;
    }

    protected List<AbstractElement> children = new ArrayList<>();

    protected Map<String, String> attributes = new HashMap<>();
    protected List<String> classes = new ArrayList<>();
    protected Map<String, String> styles = new HashMap<>();

    protected String tagName = "";
    protected String stringContent = "";

    public static final String NAME = "name";
    public static final String DISABLED = "disabled";
    public static final String A_CLASS = "class";
    public static final String ID = "id";
    public static final String STYLE = "style";

    public AbstractElement(DOM tag) {
        this.tagName = tag.value();
    }

    @Override
    public String render() {
        String attributes = this.getAttributeString();
        if (!attributes.equals(""))
            attributes = " " + attributes;

        String html = "<" + this.tagName + attributes + ">";

        for (AbstractElement content : this.children)
            html += content.render();

        html += this.stringContent;
        html += "</" + this.tagName + ">";
        return html;
    }

    protected String getAttributeString() {
        String attributeString = "";

        for (String name : this.attributes.keySet())
            attributeString += name + "=\"" + this.attributes.get(name) + "\" ";

        attributeString = attributeString.trim();

        if (this.classes.size() > 0)
            attributeString += " class=\"";

        for (String className : this.classes)
            attributeString += className + " ";

        attributeString = attributeString.trim();

        if (this.classes.size() > 0)
            attributeString += "\"";

        if (this.styles.size() > 0)
            attributeString += " style=\"";

        for (String styleName : this.styles.keySet())
            attributeString += styleName + ": " + this.styles.get(styleName) + "; ";

        attributeString = attributeString.trim();

        if (this.styles.size() > 0)
            attributeString += "\"";

        return attributeString;
    }

    public int getChildrenCount() {
        return this.children.size();
    }

    public void addAttribute(String name, String value) {
        this.attributes.put(name, value);
    }

    public void addStyle(String style, String value) {
        this.styles.put(style, value);
    }

    public String getStyle(String style) {
        return this.styles.get(style);
    }

    public void addClass(String className) {
        this.classes.add(className);
    }

    public void setName(String name) {
        this.addAttribute("name", name);
    }

    public String getName() {
        return this.attributes.get("name");
    }

    public void setHeight(int height) {
        this.addStyle("height", height + "px");
    }

    public int getHeight() {
        return Integer.valueOf(this.getStyle("height").replaceAll("\\D", ""));
    }

    public void setWidth(int width) {
        this.addStyle("width", width + "px");
    }

    public int getWidth() {
        return Integer.valueOf(this.getStyle("width").replaceAll("\\D", ""));
    }

    public void setLeft(int left) {
        this.addStyle("left", left + "px");
    }

    public int getLeft() {
        return Integer.valueOf(this.getStyle("left").replaceAll("\\D", ""));
    }

    public void setRight(int right) {
        this.addStyle("right", right + "px");
    }

    public int getRight() {
        return Integer.valueOf(this.getStyle("right").replaceAll("\\D", ""));
    }

    public void setTop(int top) {
        this.addStyle("top", top + "px");
    }

    public int getTop() {
        return Integer.valueOf(this.getStyle("top").replaceAll("\\D", ""));
    }

    public void setBottom(int bottom) {
        this.addStyle("bottom", bottom + "px");
    }

    public int getBottom() {
        return Integer.valueOf(this.getStyle("bottom").replaceAll("\\D", ""));
    }

    public void addChild(AbstractElement content) {
        this.children.add(content);
    }

    public void appendString(String string) {
        this.stringContent += string;
    }

    public void setString(String string) {
        this.stringContent = string;
    }

    public String getStringContent() {
        return this.stringContent;
    }

    public void setPosition(Position position) {
        this.addStyle("position", position.value);
    }

    public String getPosition() {
        return this.getStyle("position");
    }

    public void setId(String id) {
        this.attributes.put(ID, id);
    }

    public String getId() {
        return this.attributes.get(ID);
    }

    public void setDisabled(boolean disabled) {
        if (disabled)
            this.addAttribute(DISABLED, DISABLED);
        else
            this.attributes.remove(DISABLED);
    }

    public boolean getDisabled() {
        if (this.attributes.get(DISABLED).equals(DISABLED))
            return true;
        else
            return false;
    }

}
