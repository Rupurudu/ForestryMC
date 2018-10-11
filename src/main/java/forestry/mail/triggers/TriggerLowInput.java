/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 ******************************************************************************/
package forestry.mail.triggers;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

import forestry.core.triggers.Trigger;
import forestry.mail.tiles.TileTrader;

import buildcraft.api.statements.IStatementContainer;
import buildcraft.api.statements.IStatementParameter;

public class TriggerLowInput extends Trigger {

	private final float threshold;

	public TriggerLowInput(String tag, float threshold) {
		super(tag, "lowInput", "low_input");
		this.threshold = threshold;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " < " + threshold * 100 + "%";
	}

	@Override
	public boolean isTriggerActive(TileEntity tile, EnumFacing side, IStatementContainer source, IStatementParameter[] parameters) {

		if (!(tile instanceof TileTrader)) {
			return false;
		}

		return !((TileTrader) tile).hasInputBufMin(threshold);
	}
}
