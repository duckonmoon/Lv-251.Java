package com.softserve.edu.lv251.service.impl;

/**
 *
 */
//@Service
//public class PagingSizeServiceImpl<T> implements PagingSizeService<T> {

//    @Autowired()
//    BaseDAO<T> baseDAO;
//
//    @Override
//    public int numberOfPaging(Integer size) {
//        int n = baseDAO.getAllEntities().size();
//        return ((int) Math.ceil((double) n/size));
//    }
//
//    @Override
//    public List<T> getEntity(Integer chainIndex, Integer size) {
//        return baseDAO.pagination(chainIndex, size);
//    }
//
//    @Override
//    public List<Integer> listOfVariants(){
//        List<Integer> listOfVariants = null;
//        Integer countEntity = baseDAO.getAllEntities().size();
//        if (countEntity <= 10) {
//            listOfVariants.add(countEntity);
//        } else  if (countEntity <= 20) {
//            listOfVariants.add(10);
//            listOfVariants.add(countEntity);
//        } else if (countEntity <= 50){
//            listOfVariants.add(10);
//            listOfVariants.add(20);
//            listOfVariants.add(countEntity);
//        } else if (countEntity <= 100) {
//            listOfVariants.add(10);
//            listOfVariants.add(20);
//            listOfVariants.add(50);
//            listOfVariants.add(countEntity);
//        } else {
//            listOfVariants.add(10);
//            listOfVariants.add(20);
//            listOfVariants.add(50);
//            listOfVariants.add(100);
//            listOfVariants.add(countEntity);
//        }
//        return listOfVariants;
//    }
//}
