package com.example.wordfilterapp.aspect;

import com.example.wordfilterapp.service.WordFilterService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Aspecto que intercepta los mensajes y aplica el filtrado de palabras.
 * Utiliza AOP para evitar modificar el código original de las clases.
 */
@Aspect
@Component
public class WordFilterAspect {

    private final WordFilterService wordFilterService;

    @Autowired
    public WordFilterAspect(WordFilterService wordFilterService) {
        this.wordFilterService = wordFilterService;
    }

    /**
     * Advice que intercepta las llamadas a métodos que procesan mensajes y
     * aplica el filtro de palabras.
     *
     * @param joinPoint El punto de unión que representa la llamada al método
     * @return El resultado modificado después de aplicar el filtro
     * @throws Throwable Si ocurre un error durante la ejecución
     */
    @Around("execution(* com.example.wordfilterapp.service.*.process*(String, ..)) || " +
            "execution(* com.example.wordfilterapp.controller.*.process*(*, ..))")
    public Object filterMessageAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        // Filtra los argumentos que son cadenas de texto
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                args[i] = wordFilterService.filterMessage((String) args[i]);
            }
        }

        // Continúa con la ejecución del método original
        return joinPoint.proceed(args);
    }
}