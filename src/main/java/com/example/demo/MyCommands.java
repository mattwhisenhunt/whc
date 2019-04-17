package com.example.demo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class MyCommands {

    @ShellMethod("Busta Ca$h.")
	@CacheEvict(value="wind", allEntries=true)
    public String bust() {
        return "Okay";
    }

    @ShellMethod("Quit.")
	public void q() {
	    System.exit(0);
	}
}
