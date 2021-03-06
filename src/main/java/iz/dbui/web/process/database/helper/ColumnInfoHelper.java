package iz.dbui.web.process.database.helper;

import iz.dbui.web.process.database.dto.Column;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author iz_j
 *
 */
public final class ColumnInfoHelper {
	private ColumnInfoHelper() {
	}

	/**
	 * @param columns
	 * @return column names
	 */
	public static List<String> toColumnNames(List<Column> columns) {
		return columns.stream().map(column -> {
			return column.columnName;
		}).collect(Collectors.toList());
	}

	/**
	 * @param sourceColumns
	 * @param checkColumnNames
	 * @return true if source contains all check column names
	 */
	public static boolean containsAll(List<Column> sourceColumns, List<String> checkColumnNames) {
		return checkColumnNames.stream().allMatch(columnName -> {
			return sourceColumns.stream().anyMatch(column -> {
				return StringUtils.equalsIgnoreCase(column.columnName, columnName);
			});
		});
	}

	/**
	 * @param columns
	 * @param pks
	 * @return index list of primary keys
	 */
	public static List<Integer> primaryKeyIndexes(List<Column> columns, List<String> pks) {
		if (CollectionUtils.isEmpty(pks)) {
			return Collections.emptyList();
		}

		return columns.stream().filter(column -> {
			return pks.stream().anyMatch(pk -> {
				return StringUtils.equalsIgnoreCase(column.columnName, pk);
			});
		}).map(column -> {
			return columns.indexOf(column);
		}).collect(Collectors.toList());
	}
}
