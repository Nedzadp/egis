/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.system;

/**
 *
 * @author Nedzad
 */
public class ServiceSingleton {
    private static ThreadLocal<IService> service = new ThreadLocal<IService>();


	public static IService get() {
            service.set(new DefaultService());
            return service.get();
	}

	public static void set(IService carService) {
		if(ServiceSingleton.get() != null) {
                    throw new RuntimeException("Service has already been created");
		}
		ServiceSingleton.service.set(carService);
	}
}
