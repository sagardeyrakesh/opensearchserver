/**   
 * License Agreement for Jaeksoft OpenSearchServer
 *
 * Copyright (C) 2008-2009 Emmanuel Keller / Jaeksoft
 * 
 * http://www.open-search-server.com
 * 
 * This file is part of Jaeksoft OpenSearchServer.
 *
 * Jaeksoft OpenSearchServer is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * Jaeksoft OpenSearchServer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Jaeksoft OpenSearchServer. 
 *  If not, see <http://www.gnu.org/licenses/>.
 **/

package com.jaeksoft.searchlib.statistics;

import java.util.Calendar;

public class MinuteStatistics extends StatisticsAbstract {

	public MinuteStatistics(StatisticTypeEnum type, boolean writeToLog,
			int maxRetention) {
		super(type, writeToLog, maxRetention);
	}

	@Override
	public Aggregate newAggregate(long startTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(startTime);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		startTime = cal.getTimeInMillis();
		cal.add(Calendar.MINUTE, 1);
		return new Aggregate(startTime, cal.getTimeInMillis());
	}

	@Override
	public StatisticPeriodEnum getPeriod() {
		return StatisticPeriodEnum.MINUTE;
	}

}
