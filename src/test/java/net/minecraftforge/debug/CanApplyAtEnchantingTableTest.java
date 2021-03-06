package net.minecraftforge.debug;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "canapplyatenchantingtabletest", name = "CanApplyAtEnchantingTableTest", version = "0.0.0", acceptableRemoteVersions = "*")
public class CanApplyAtEnchantingTableTest
{
    public static final boolean ENABLE = false;

    public static final Item testItem = new Item()
    {
        @Override
        public boolean isEnchantable(ItemStack stack)
        {
            return true;
        }

        @Override
        public int getItemEnchantability()
        {
            return 30;
        }

        @Override
        public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment)
        {
            return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment == Enchantments.FORTUNE;
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        if (ENABLE)
        {
            GameRegistry.register(testItem.setRegistryName("test_item").setUnlocalizedName("FortuneEnchantableOnly").setMaxStackSize(1));
        }
    }
}
