package org.zyd.common.vo;


public class ShapeSearchVo implements java.io.Serializable{
    private static final long serialVersionUID = 8097056387310914027L;

    private String shapeName;
    private String shapeFullSpell;
    private String shapeSimpleSpell;

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getShapeFullSpell() {
        return shapeFullSpell;
    }

    public void setShapeFullSpell(String shapeFullSpell) {
        this.shapeFullSpell = shapeFullSpell;
    }

    public String getShapeSimpleSpell() {
        return shapeSimpleSpell;
    }

    public void setShapeSimpleSpell(String shapeSimpleSpell) {
        this.shapeSimpleSpell = shapeSimpleSpell;
    }
}
