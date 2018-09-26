/*******************************************************************************
 * Copyright (c) 2018 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.alg.sequence.graph;

import java.util.List;

import org.eclipse.elk.alg.sequence.options.SequenceExecutionType;

import com.google.common.collect.Lists;

/**
 * Data structure for execution specification elements in sequence diagrams. An execution can have child executions.
 * These are nested executions this execution is the direct parent of. The nesting structure establishes how executions
 * are offset in the horizontal direction in the final layout.
 */
public final class SExecution extends SShape {

    private static final long serialVersionUID = -4034839145972542469L;

    /** The type of the execution. */
    private SequenceExecutionType type = null;
    /** The list of connected messages. */
    private final List<SMessage> messages = Lists.newArrayList();
    /** Parent execution. */
    private SExecution parent = null;
    /** Child executions. */
    private final List<SExecution> children = Lists.newArrayList();
    /** The slot the execution will be placed in. This will determine its horizontal offset in the final layout. */
    private int slot = 0;

    /**
     * Get the type of the execution.
     */
    public SequenceExecutionType getType() {
        return type;
    }

    /**
     * Set the type of the execution.
     */
    public void setType(final SequenceExecutionType type) {
        this.type = type;
    }

    /**
     * Get the list of messages that are connected to the execution.
     */
    public List<SMessage> getMessages() {
        return messages;
    }
    
    /**
     * Returns the parent execution, if any.
     */
    public SExecution getParent() {
        return parent;
    }

    /**
     * Sets the parent execution. This will not automatically add the execution to the parent's list of children.
     */
    public void setParent(final SExecution parent) {
        this.parent = parent;
    }

    /**
     * Get the list of child executions of this execution. Changes to this list are not automatically reflected in the
     * parent execution fields of affected executions.
     */
    public List<SExecution> getChildren() {
        return children;
    }

    /**
     * Returns the slot the execution will be placed in.
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Sets the slot the execution will be placed in.
     */
    public void setSlot(final int slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Messages: " + messages
                + ", Pos: (" + getPosition().x + "/" + getPosition().y
                + "), Size: (" + getSize().x + "/" + getSize().y + ")";
    }
}