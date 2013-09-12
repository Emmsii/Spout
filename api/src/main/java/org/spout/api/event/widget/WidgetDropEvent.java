/*
 * This file is part of Spout.
 *
 * Copyright (c) 2011 Spout LLC <http://www.spout.org/>
 * Spout is licensed under the Spout License Version 1.
 *
 * Spout is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Spout is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.api.event.widget;

import org.spout.api.event.Cancellable;
import org.spout.api.event.HandlerList;
import org.spout.api.gui.Widget;
import org.spout.api.math.IntVector2;

/**
 * Called when a {@link Widget} is dropped after being dragged.
 */
public class WidgetDropEvent extends WidgetEvent implements Cancellable {
	private static final HandlerList handlers = new HandlerList();
	private IntVector2 at;

	public WidgetDropEvent(Widget widget, IntVector2 at) {
		super(widget);
		this.at = at;
	}

	/**
	 * Returns the position the {@link Widget} was dropped at.
	 *
	 * @return position widget was dropped at
	 */
	public IntVector2 getAt() {
		return at;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		super.setCancelled(cancelled);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}