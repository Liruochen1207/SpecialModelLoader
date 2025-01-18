package dev.felnull.specialmodelloader.impl.model;

import dev.felnull.specialmodelloader.api.model.ModelOption;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.UnbakedModel;

public abstract class SpecialBaseUnbakedModel implements UnbakedModel {
    protected static final Material MISSING = new Material(TextureAtlas.LOCATION_BLOCKS, MissingTextureAtlasSprite.getLocation());
    private final ModelOption modelOption;

    protected SpecialBaseUnbakedModel(ModelOption modelOption) {
        this.modelOption = modelOption;
    }

    public ModelOption getModelOption() {
        return modelOption;
    }

    public Material getParticleLocation() {
        if (modelOption.getParticle() != null)
            return new Material(TextureAtlas.LOCATION_BLOCKS, modelOption.getParticle());
        return MISSING;
    }

    public BlockModel.GuiLight getGuiLight() {
        if (modelOption.getGuiLight() == null)
            return BlockModel.GuiLight.SIDE;
        return modelOption.getGuiLight();
    }
}
