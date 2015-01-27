package com.SimpleCampfire;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Campfire - Derpford
 * Created using Tabula 4.1.1
 */
public class CampfireModel extends ModelBase {
    public ModelRenderer stick1;
    public ModelRenderer stick2;
    public ModelRenderer stick3;
    public ModelRenderer stick4;
    public ModelRenderer base;
    public ModelRenderer stonene;
    public ModelRenderer stonen;
    public ModelRenderer stonenw;
    public ModelRenderer stones;
    public ModelRenderer stonew;
    public ModelRenderer stonee;
    public ModelRenderer stonese;
    public ModelRenderer stonesw;

    public CampfireModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.stonee = new ModelRenderer(this, 0, 0);
        this.stonee.setRotationPoint(0.0F, -3.0F, 6.0F);
        this.stonee.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setRotationPoint(-8.0F, 23.0F, -8.0F);
        this.base.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16, 0.0F);
        this.stick2 = new ModelRenderer(this, 52, 0);
        this.stick2.mirror = true;
        this.stick2.setRotationPoint(-3.0F, 22.0F, 2.5F);
        this.stick2.addBox(0.0F, -9.0F, 0.0F, 1, 10, 1, 0.0F);
        this.setRotateAngle(stick2, 0.3490658503988659F, 0.0F, 0.3490658503988659F);
        this.stonesw = new ModelRenderer(this, 0, 0);
        this.stonesw.setRotationPoint(10.3F, -3.0F, 13.0F);
        this.stonesw.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(stonesw, 0.0F, 0.7853981633974483F, 0.0F);
        this.stonese = new ModelRenderer(this, 0, 0);
        this.stonese.setRotationPoint(-0.1F, -3.0F, 13.0F);
        this.stonese.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(stonese, 0.0F, 0.7853981633974483F, 0.0F);
        this.stones = new ModelRenderer(this, 0, 0);
        this.stones.setRotationPoint(5.9F, -3.0F, 12.0F);
        this.stones.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.stonenw = new ModelRenderer(this, 0, 0);
        this.stonenw.setRotationPoint(10.3F, -3.0F, 3.0F);
        this.stonenw.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(stonenw, 0.0F, 0.7853981633974483F, 0.0F);
        this.stonen = new ModelRenderer(this, 0, 0);
        this.stonen.setRotationPoint(5.9F, -3.0F, 0.0F);
        this.stonen.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.stick1 = new ModelRenderer(this, 52, 0);
        this.stick1.setRotationPoint(2.5F, 22.0F, 2.5F);
        this.stick1.addBox(0.0F, -9.0F, 0.0F, 1, 10, 1, 0.0F);
        this.setRotateAngle(stick1, 0.3490658503988659F, 0.0F, -0.3490658503988659F);
        this.stick3 = new ModelRenderer(this, 48, 0);
        this.stick3.setRotationPoint(-3.0F, 22.0F, -3.0F);
        this.stick3.addBox(0.0F, -9.0F, 0.0F, 1, 10, 1, 0.0F);
        this.setRotateAngle(stick3, -0.3490658503988659F, 0.0F, 0.3490658503988659F);
        this.stonene = new ModelRenderer(this, 0, 0);
        this.stonene.setRotationPoint(-0.1F, -3.0F, 3.0F);
        this.stonene.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(stonene, 0.0F, 0.7853981633974483F, 0.0F);
        this.stonew = new ModelRenderer(this, 0, 0);
        this.stonew.setRotationPoint(12.0F, -3.0F, 6.0F);
        this.stonew.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.stick4 = new ModelRenderer(this, 48, 0);
        this.stick4.mirror = true;
        this.stick4.setRotationPoint(2.5F, 22.0F, -3.0F);
        this.stick4.addBox(0.0F, -9.0F, 0.0F, 1, 10, 1, 0.0F);
        this.setRotateAngle(stick4, -0.3490658503988659F, 0.0F, -0.3490658503988659F);
        this.base.addChild(this.stonee);
        this.base.addChild(this.stonesw);
        this.base.addChild(this.stonese);
        this.base.addChild(this.stones);
        this.base.addChild(this.stonenw);
        this.base.addChild(this.stonen);
        this.base.addChild(this.stonene);
        this.base.addChild(this.stonew);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.base.render(f5);
        this.stick2.render(f5);
        this.stick1.render(f5);
        this.stick3.render(f5);
        this.stick4.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
