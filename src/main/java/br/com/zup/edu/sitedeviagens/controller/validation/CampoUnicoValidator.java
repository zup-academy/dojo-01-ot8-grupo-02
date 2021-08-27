package br.com.zup.edu.sitedeviagens.controller.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CampoUnicoValidator implements ConstraintValidator<CampoUnicoConstraint, Object> {

    private String campo;
    private Class<?> modelClass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(CampoUnicoConstraint constraintAnnotation) {
        campo = constraintAnnotation.campo();
        modelClass = constraintAnnotation.modelClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("SELECT 1 FROM " + this.modelClass.getName() + " WHERE " + this.campo + "=:param")
                .setParameter("param", value);
        List<?> list = query.getResultList();
        return (list.isEmpty());
    }
}
