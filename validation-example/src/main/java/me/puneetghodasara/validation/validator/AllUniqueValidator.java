package me.puneetghodasara.validation.validator;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

public class AllUniqueValidator implements ConstraintValidator<AllUnique, List<? extends Object>> {

	private String uniqeFieldValueName;

	@Override
	public void initialize(AllUnique constraintAnnotation) {
		uniqeFieldValueName = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(List<? extends Object> valueList, ConstraintValidatorContext context) {

		Set<Object> fieldValues = new HashSet<>();

		if (valueList == null)
			return true;

		for (Object aValue : valueList) {
			Field field;
			try {
				field = aValue.getClass()
						.getDeclaredField(uniqeFieldValueName);

				field.setAccessible(true);
				Object fValue = field.get(aValue);

				if (fieldValues.contains(fValue)) {
					ConstraintViolationBuilder template = context.buildConstraintViolationWithTemplate(
							"Values of field " + field.getName() + " are not unique across collection.");
					template.addConstraintViolation();
					return false;
				}
				fieldValues.add(fValue);

			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				ConstraintViolationBuilder template = context
						.buildConstraintViolationWithTemplate("Exception " + uniqeFieldValueName + ":" + e.getClass()
								.getName() + " :" + e.getMessage());
				template.addConstraintViolation();
				return false;
			}

		}

		return true;
	}

}
