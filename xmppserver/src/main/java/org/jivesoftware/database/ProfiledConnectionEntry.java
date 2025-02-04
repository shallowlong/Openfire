/*
 * Copyright (C) 2004 Jive Software, 2017-2020 Ignite Realtime Foundation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jivesoftware.database;

import java.time.Duration;

/**
 * Simple class for tracking profiling stats for individual SQL queries.
 *
 * @author Jive Software
 */
public class ProfiledConnectionEntry {
    /**
     * The SQL query.
     */
    public String sql;

    /**
     * Number of times the query has been executed.
     */
    public int count;

    /**
     * The total time spent executing the query.
     */
    public Duration totalTime;

    public ProfiledConnectionEntry(String sql) {
        this.sql = sql;
        count = 0;
        totalTime = Duration.ZERO;
    }

    public String getSql()
    {
        return sql;
    }

    public void setSql(String sql)
    {
        this.sql = sql;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public Duration getTotalTime()
    {
        return totalTime;
    }

    public void setTotalTime(Duration totalTime)
    {
        this.totalTime = totalTime;
    }

    public Duration getAverageTime() {
        return this.totalTime.dividedBy(count);
    }
}
