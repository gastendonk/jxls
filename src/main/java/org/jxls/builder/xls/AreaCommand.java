package org.jxls.builder.xls;

import org.jxls.common.Size;
import org.jxls.command.AbstractCommand;
import org.jxls.common.CellRef;
import org.jxls.common.Context;

/**
 * A container area command used in {@link XlsCommentAreaBuilder} to enclose other commands
 * @author Leonid Vysochyn
 */
public class AreaCommand extends AbstractCommand {

    public static final String COMMAND_NAME = "area";
    private String clearCells;

    public String getName() {
        return COMMAND_NAME;
    }

    public Size applyAt(CellRef cellRef, Context context) {
        return Size.ZERO_SIZE;
    }

    public String getClearCells() {
        return clearCells;
    }

    public void setClearCells(String clearCells) {
        this.clearCells = clearCells;
    }
}
