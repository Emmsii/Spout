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
package org.spout.engine.entity;

import org.spout.api.Client;
import org.spout.api.Engine;
import org.spout.api.component.Component;
import org.spout.api.component.entity.CameraComponent;
import org.spout.api.component.entity.PlayerNetworkComponent;
import org.spout.api.geo.discrete.Transform;

import org.spout.engine.component.entity.SpoutFallbackMovementComponent;
import org.spout.engine.gui.SpoutScreenStack;

/**
 * A subclass of SpoutPlayer with modifications for the client
 */
public class SpoutClientPlayer extends SpoutPlayer {
	public SpoutClientPlayer(Engine engine, Class<? extends PlayerNetworkComponent> network, String name, Transform transform) {
		super(engine, network, name, transform, null, (byte[]) null, (Class<? extends Component>[]) null);

		add(CameraComponent.class);
		// TODO clearly, this should only be a fallback component
		add(SpoutFallbackMovementComponent.class);
	}

	@Override
	public void sendMessage(String message) {
		((SpoutScreenStack) ((Client) getEngine()).getScreenStack()).getConsole().addMessage(message);
	}
}
