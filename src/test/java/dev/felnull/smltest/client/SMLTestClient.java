package dev.felnull.smltest.client;

import dev.felnull.smltest.SMLTest;
import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.client.renderer.special.SpecialModelRenderers;
import net.minecraft.resources.ResourceLocation;

public class SMLTestClient implements ClientModInitializer {
    public static final ResourceLocation TEST_OBJ_MODEL = ResourceLocation.fromNamespaceAndPath(SMLTest.MODID, "item/obj_model_item_dynamic");

    @Override
    public void onInitializeClient() {
        SpecialModelLoaderEvents.LOAD_SCOPE.register(() -> (resManager, location) -> SMLTest.MODID.equals(location.getNamespace()));
        ModelLoadingPlugin.register(pluginContext -> pluginContext.addModels(TEST_OBJ_MODEL));

        SpecialModelRenderers.ID_MAPPER.put(
                ResourceLocation.fromNamespaceAndPath(SMLTest.MODID, "dynamic_obj_model_item"),
                DynamicObjModelItemSpecialRenderer.Unbaked.MAP_CODEC
        );
    }
}
