package net.conczin.man_of_many_planes.client;

import net.minecraft.nbt.CompoundTag;

public class ColorUtils
{
	public static int[] hexToRGB(int color)
	{
		int r = (color & 0xff0000) >> 16;
		int g = (color & 0x00ff00) >> 8;
		int b = (color & 0x0000ff);

		return new int[]{r, g, b};
	}

	public static float[] hexToDecimalRGB(int color)
	{
		float r = ((color & 0xff0000) >> 16) / 255f;
		float g = ((color & 0x00ff00) >> 8) / 255f;
		float b = (color & 0x0000ff) / 255f;

		return new float[]{r, g, b};
	}

	public static int getDisplayColorFromNbt(CompoundTag tag) {
		CompoundTag compoundTag = tag.getCompound("display");
		return compoundTag.contains("color", 99) ? compoundTag.getInt("color") : -1;
	}

	public static void setDisplayColorFromNbt(CompoundTag tag, int i)
	{
		if(!tag.contains("display"))
			tag.put("display", new CompoundTag());
		tag.getCompound("display").putInt("color", i);
	}
}