package com.attozoic.main.model.dto;

import java.util.List;

import com.attozoic.main.model.ActivityFinancialSource;

import lombok.Data;

@Data
public class DtoBalanceActivityFinancialSourceListObject {

	private double year;
	private List<ActivityFinancialSource> activityFinancialSources;
	
	public DtoBalanceActivityFinancialSourceListObject() {}
	
	public DtoBalanceActivityFinancialSourceListObject(double year, List<ActivityFinancialSource> activityFinancialSources) {
		this.year = year;
		this.activityFinancialSources = activityFinancialSources;
	}
	
	// Sabira 2 ovakva objekta, zadrzava podatke THIS objekta i sabira im liste List<ActivityFinancialSource> metodom ispod
//	public DtoBalanceActivityFinancialSourceListObject sumDtoBalanceActivityFinancialSourceListObjects(DtoBalanceActivityFinancialSourceListObject dto) {
//		return new DtoBalanceActivityFinancialSourceListObject(this.getYear(), this.sumLists(dto.activityFinancialSources));
//	}
	
	// Sabira List<ActivityFinancialSource> Objekta THIS i List<ActivityFinancialSource> koju mu prosledjujem
//	private List<ActivityFinancialSource> sumLists(List<ActivityFinancialSource> activityFinancialSources) {
//		Map<String, ActivityFinancialSource> map = new HashMap<>();
//		List<ActivityFinancialSource> list = new ArrayList<>();
//		for (ActivityFinancialSource activityFinancialSource : this.activityFinancialSources) {
//			if (map.containsKey(activityFinancialSource.getName())) {
//				map.put(activityFinancialSource.getName(), map.get(activityFinancialSource.getName()).sumActivityFinancialSources(activityFinancialSource));
//			} else {
//				map.put(activityFinancialSource.getName(), activityFinancialSource);
//			}
//		}
//		for (ActivityFinancialSource activityFinancialSource : activityFinancialSources) {
//			if (map.containsKey(activityFinancialSource.getName())) {
//				map.put(activityFinancialSource.getName(), map.get(activityFinancialSource.getName()).sumActivityFinancialSources(activityFinancialSource));
//			} else {
//				map.put(activityFinancialSource.getName(), activityFinancialSource);
//			}
//		}
//		for (Map.Entry<String, ActivityFinancialSource> entry : map.entrySet()) {
//			list.add(entry.getValue());
//		}
//		return list;
//	}
	
}
